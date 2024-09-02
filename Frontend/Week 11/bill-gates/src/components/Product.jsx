import { useContext, useEffect } from "react";
import { MoneyContext } from "../context/MoneyContext";
import { useState } from "react";
const data = [
    {
      id: 1,
      title: "Big Mac",
      picture: "https://neal.fun/spend/images/big-mac.jpg",
      price: 2,
    },
    {
      id: 2,
      title: "Flip Flops",
      picture: "https://neal.fun/spend/images/flip-flops.jpg",
      price: 3,
    },
    {
      id: 3,
      title: "Coca-Cola Pack",
      picture: "https://neal.fun/spend/images/coca-cola-pack.jpg",
      price: 5,
    },
    {
      id: 4,
      title: "Movie Ticket",
      picture: "https://neal.fun/spend/images/movie-ticket.jpg",
      price: 12,
    },
    {
      id: 5,
      title: "Book",
      picture: "https://neal.fun/spend/images/book.jpg",
      price: 15,
    },
    {
      id: 6,
      title: "Lobster Dinner",
      picture: "https://neal.fun/spend/images/lobster-dinner.jpg",
      price: 45,
    },
    {
      id: 7,
      title: "Video Game",
      picture: "https://neal.fun/spend/images/video-game.jpg",
      price: 60,
    },
    {
      id: 8,
      title: "Amazon Echo",
      picture: "https://neal.fun/spend/images/amazon-echo.jpg",
      price: 99,
    },
    {
      id: 9,
      title: "Year of Netflix",
      picture: "https://neal.fun/spend/images/year-of-netflix.jpg",
      price: 100,
    },
    {
      id: 10,
      title: "Air Jordans",
      picture: "https://neal.fun/spend/images/air-jordans.jpg",
      price: 125,
    },
    {
      id: 11,
      title: "Airpods",
      picture: "https://neal.fun/spend/images/airpods.jpg",
      price: 199,
    },
    {
      id: 12,
      title: "Gaming Console",
      picture: "https://neal.fun/spend/images/gaming-console.jpg",
      price: 299,
    },
    {
      id: 13,
      title: "Drone",
      picture: "https://neal.fun/spend/images/drone.jpg",
      price: 350,
    },
    {
      id: 14,
      title: "Smartphone",
      picture: "https://neal.fun/spend/images/smartphone.jpg",
      price: 699,
    },
    {
      id: 15,
      title: "Bike",
      picture: "https://neal.fun/spend/images/bike.jpg",
      price: 800,
    },
    {
      id: 16,
      title: "Kitten",
      picture: "https://neal.fun/spend/images/kitten.jpg",
      price: 1500,
    },
    {
      id: 17,
      title: "Puppy",
      picture: "https://neal.fun/spend/images/puppy.jpg",
      price: 1500,
    },
    {
      id: 18,
      title: "Auto Rickshaw",
      picture: "https://neal.fun/spend/images/auto-rickshaw.jpg",
      price: 2300,
    },
    {
      id: 19,
      title: "Horse",
      picture: "https://neal.fun/spend/images/horse.jpg",
      price: 2500,
    },
    {
      id: 20,
      title: "Acre of Farmland",
      picture: "https://neal.fun/spend/images/acre-of-farmland.jpg",
      price: 3000,
    },
    {
      id: 21,
      title: "Designer Handbag",
      picture: "https://neal.fun/spend/images/designer-handbag.jpg",
      price: 5500,
    },
    {
      id: 22,
      title: "Hot Tub",
      picture: "https://neal.fun/spend/images/hot-tub.jpg",
      price: 6000,
    },
    {
      id: 23,
      title: "Luxury Wine",
      picture: "https://neal.fun/spend/images/luxury-wine.jpg",
      price: 7000,
    },
    {
      id: 24,
      title: "Diamond Ring",
      picture: "https://neal.fun/spend/images/diamond-ring.jpg",
      price: 10000,
    },
    {
      id: 25,
      title: "Jet Ski",
      picture: "https://neal.fun/spend/images/jet-ski.jpg",
      price: 12000,
    },
    {
      id: 26,
      title: "Rolex",
      picture: "https://neal.fun/spend/images/rolex.jpg",
      price: 15000,
    },
    {
      id: 27,
      title: "Ford F-150",
      picture: "https://neal.fun/spend/images/ford-f-150.jpg",
      price: 30000,
    },
    {
      id: 28,
      title: "Tesla",
      picture: "https://neal.fun/spend/images/tesla.jpg",
      price: 75000,
    },
    {
      id: 29,
      title: "Monster Truck",
      picture: "https://neal.fun/spend/images/monster-truck.jpg",
      price: 150000,
    },
    {
      id: 30,
      title: "Ferrari",
      picture: "https://neal.fun/spend/images/ferrari.jpg",
      price: 250000,
    },
    {
      id: 31,
      title: "Single Family Home",
      picture: "https://neal.fun/spend/images/single-family-home.jpg",
      price: 300000,
    },
    {
      id: 32,
      title: "Gold Bar",
      picture: "https://neal.fun/spend/images/gold-bar.jpg",
      price: 700000,
    },
    {
      id: 33,
      title: "McDonalds Franchise",
      picture: "https://neal.fun/spend/images/mcdonalds-franchise.jpg",
      price: 1500000,
    },
    {
      id: 34,
      title: "Superbowl Ad",
      picture: "https://neal.fun/spend/images/superbowl-ad.jpg",
      price: 5250000,
    },
    {
      id: 35,
      title: "Yacht",
      picture: "https://neal.fun/spend/images/yacht.jpg",
      price: 7500000,
    },
    {
      id: 36,
      title: "M1 Abrams",
      picture: "https://neal.fun/spend/images/m1-abrams.jpg",
      price: 8000000,
    },
    {
      id: 37,
      title: "Formula 1 Car",
      picture: "https://neal.fun/spend/images/formula-1-car.jpg",
      price: 15000000,
    },
    {
      id: 38,
      title: "Apache Helicopter",
      picture: "https://neal.fun/spend/images/apache-helicopter.jpg",
      price: 31000000,
    },
    {
      id: 39,
      title: "Mansion",
      picture: "https://neal.fun/spend/images/mansion.jpg",
      price: 45000000,
    },
    {
      id: 40,
      title: "Make a Movie",
      picture: "https://neal.fun/spend/images/make-a-movie.jpg",
      price: 100000000,
    },
    {
      id: 41,
      title: "Boeing 747",
      picture: "https://neal.fun/spend/images/boeing-747.jpg",
      price: 148000000,
    },
    {
      id: 42,
      title: "Mona Lisa",
      picture: "https://neal.fun/spend/images/mona-lisa.jpg",
      price: 780000000,
    },
    {
      id: 43,
      title: "Skyscraper",
      picture: "https://neal.fun/spend/images/skyscraper.jpg",
      price: 850000000,
    },
    {
      id: 44,
      title: "Cruise Ship",
      picture: "https://neal.fun/spend/images/cruise-ship.jpg",
      price: 930000000,
    },
    {
      id: 45,
      title: "NBA Team",
      picture: "https://neal.fun/spend/images/nba-team.jpg",
      price: 2120000000,
    },
  ]
  function Product() {
    const { money, setMoney } = useContext(MoneyContext);
    const [quantities, setQuantities] = useState({}); // Her ürün için adetleri tutar.
    
    useEffect(() => {
        const initialQuantities = data.reduce((acc, item) => {
          acc[item.id] = 0;
          return acc;
        }, {});
        setQuantities(initialQuantities);
      }, []);
    

    const handleBuy = (id, price) => {
        const currentQuantity = quantities[id] || 0;
        const newQuantity = currentQuantity + 1;
        setQuantities(prevQuantities => ({
            ...prevQuantities,
            [id]: newQuantity
        }));
        setMoney(money - price);
    };

    const handleSell = (id, price) => {
        const currentQuantity = quantities[id] || 0;
        if (currentQuantity > 0) {
            const newQuantity = currentQuantity - 1;
            setQuantities(prevQuantities => ({
                ...prevQuantities,
                [id]: newQuantity
            }));
            setMoney(money + price);
        }
    };

    const handleInputChange = (id, value) => {
        const numericValue = Number(value);
        const currentQuantity = quantities[id] || 0;
        const difference = numericValue - currentQuantity;

        setQuantities(prevQuantities => ({
            ...prevQuantities,
            [id]: numericValue
        }));
        setMoney(money - difference * data.find(item => item.id === id).price);
    };

    const listItems = data.map(item => 
        <div key={item.id} className="item">
            <img src={item.picture} alt="" />
            <p>{item.title}</p>
            <p className="bold">{item.price}</p>
            <div className="button-area">
                <button disabled={quantities[item.id] === 0} onClick={() => handleSell(item.id, item.price)}>Sell</button>
                <input 
                    type="number"
                    value={quantities[item.id] || 0}
                    onChange={(e) => handleInputChange(item.id, e.target.value)}
                    min="0"
                    
                />
                <button onClick={() => handleBuy(item.id, item.price)}>Buy</button>
            </div>
        </div>
    );
  
    return (
        <div className="item-container">
            {listItems}
        </div>
    );
}

export default Product;
