import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Card } from './components/card/card';
import { FoodData } from './interface/FoodData';

function App() {

  const data: FoodData[] = [];
  return (
    <div className="container">
      <h1>Cardapio</h1>
      <div className="card-grid">
        {data.map(foodData => 
          <Card 
            price={foodData.price} 
            title={foodData.title} 
            image={foodData.image}
          />
        )}
      </div>
    </div>
  )
}

export default App
