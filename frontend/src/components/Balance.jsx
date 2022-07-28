import React from 'react';
import dump from '../assets/dump.png'
import AddTransaction from './AddTransaction';
import api from '../api/transactions'
import Transactions from '../api/transactions';


function Balance(props) {
  // **** ENTRADA ****
  
  var arrayIncome = []
  props.list.length && props.list.map((item) => {
    if(item.type === "ENTRADA"){
      arrayIncome.push(item.amount)
    }
  })

  var sumIncome = 0;

  for (let i = 0; i < arrayIncome.length; i++) {
      sumIncome += arrayIncome[i];
  }
  
  // **** SAIDA ****

  var arrayExpense = []
  props.list.length && props.list.map((item) => {
    if(item.type === "SAIDA"){
      arrayExpense.push(item.amount)
    }
  })

  var sumExpense = 0;

  for (let i = 0; i < arrayExpense.length; i++) {
      sumExpense += arrayExpense[i];
  }

  // **** BALANÇO ****

  var balance = sumIncome - sumExpense


  // **** ArrayName ****

  var arrayName = []
  props.list.length && props.list.map((item) => {
    arrayName.push(item)
  })

  const handleDelete = (id) => {
    api.delete(`/launch/${id.target.alt}`)
  }

  return (
    <>
      <div className='balance-container'>
        <span className='balance'>SEU BALANÇO:</span>  <span className='n-balance'>R$ {balance}</span>
        <div className='balance-box'>
          <div className='income'>
            <p className='title-t'>ENTRADAS</p>
            <p className='value-v'>R$ {sumIncome >= 0 && sumIncome}</p>
          </div>
          <div className='expense'>
            <p className='title-t'>SAÍDAS</p>
            <p className='value-e'>R$ {sumExpense >= 0 && sumExpense}</p>
          </div>
        </div>
      </div>
      <div className='transactions-history'>
        <p className='history-title'>HISTÓRICO</p>
        <div className='history-items'>
          {arrayName.map(item => 
            <div className='btn-hover' key={item.id}>
            
            <button className='delete-btn' onClick={handleDelete}><img src={dump} alt={item.id} /></button>

            <div className={item.type === "ENTRADA" ? "history-item-income" : "history-item-expense"}>
              <span className='history-description'>{item.name}</span>
              <span className='history-value'>R$ {item.type === "ENTRADA" ? `+ ${item.amount}` : `- ${item.amount}`}</span>
            </div>
            </div> 
          )}
        </div>
      </div>
      <AddTransaction/>
    </>
  )
}

export default Balance;