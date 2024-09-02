import './App.css'
import Header from './components/Header'
import Money from './components/Money'
import Product from './components/Product'
import { MoneyProvider } from './context/MoneyContext'
import Invoice from './components/Invoice'

function App() {
  return (
    <MoneyProvider>
      <Header />
      <Money />
      <Product/>
      <Invoice/>
    </MoneyProvider>
    
  )
}

export default App
