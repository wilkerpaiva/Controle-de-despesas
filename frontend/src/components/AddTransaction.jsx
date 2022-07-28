import React, { useState } from 'react'
import api from '../api/transactions'

function AddTransaction() {

    const [formData, setFormData] = useState(
        {
            type: "",
            name: "",
            amount: ""
        }    
    )

    function handleChange(e) {
        const {name, value} = e.target
        setFormData(prevFormData => {
            return {
                ...prevFormData,
                [name]: value
            }
        })
    }

    const handleSubmit = () => {
        api.post('/launch', formData)
    }

  return (
    <div className='add-transaction'>
        <p className='add-transaction-title'>ADICIONAR NOVA TRANSAÇÃO</p>
        <form onSubmit={handleSubmit}>
            <label htmlFor="addtipo">TIPO</label>
            <br />
            <select 
                id="addtipo" 
                value={formData.type} 
                onChange={handleChange} 
                name="type"
                required
            >
                <option value="">-- Escolha o tipo de transação --</option>
                <option value="ENTRADA">ENTRADA</option>
                <option value="SAIDA">SAIDA</option>
            </select>
            <label htmlFor="add-description">DESCRIÇÃO</label>
            <br />
            <input 
                type="text"
                placeholder='EX: conta de luz'
                name='name'
                id='add-description'
                onChange={handleChange}
                value={formData.name}
                required
            />
            <label htmlFor="add-value">QUANTIA R$:</label>
            <br />
            <input 
                type="number"
                placeholder='200'
                name='amount'
                id='add-value'
                onChange={handleChange}
                value={formData.amount}
                required
            />
            <button className='form-btn'>ADICIONAR TRANSAÇÃO</button>
        </form>
    </div>
  )
}

export default AddTransaction;