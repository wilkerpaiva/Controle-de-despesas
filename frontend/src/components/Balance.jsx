import React from 'react';

function Balance() {
  return (
    <div className='balance-container'>
      <span className='balance'>SEU BALANÇO:</span> &nbsp;&nbsp;&nbsp; <span className='n-balance'>R$ -200.00</span>
      <div className='balance-box'>
        <div className='income'>
          <p className='title-t'>ENTRADAS</p>
          <p className='value-v'>R$ 200.00</p>
        </div>
        <div className='expense'>
          <p className='title-t'>SAÍDAS</p>
          <p className='value-e'>R$ 500.00</p>
        </div>
      </div>
    </div>
  )
}

export default Balance;