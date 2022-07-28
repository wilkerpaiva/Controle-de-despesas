import React, { useEffect, useState } from 'react'
import Balance from './components/Balance'
import api from './api/transactions'

function App() {
  const [values, setValues] = useState([])

  const obterDados = async () => {
    const dados = await api.get('/launch');
    const allValues = dados.data;
    setValues(allValues)
  }

  useEffect(() => {
    obterDados()
  //  console.log(values)
  }, [])

  return (
    <main>
      <h1>CONTROLE DE DESPESAS</h1>
     <Balance list={values} />
    </main>
  )
}

export default App