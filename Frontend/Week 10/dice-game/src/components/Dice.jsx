import React, { useState, useEffect } from 'react';
import dice1 from '../assets/dice1.png';
import dice2 from '../assets/dice2.png';
import dice3 from '../assets/dice3.png';
import dice4 from '../assets/dice4.png';
import dice5 from '../assets/dice5.png';
import dice6 from '../assets/dice6.png';

function Dice({ value, showRandom }) {
  const [displayValue, setDisplayValue] = useState(1);

  useEffect(() => {
    if (showRandom) {
      const interval = setInterval(() => {
        setDisplayValue((prev) => (prev % 6) + 1);
      }, 100); // Her 100 ms'de bir yeni zar değeri göster

      // 3 saniye sonra zarları durdur
      const timer = setTimeout(() => {
        clearInterval(interval);
        setDisplayValue(value); // Son değeri göster
      }, 3000);

      return () => {
        clearInterval(interval);
        clearTimeout(timer);
      };
    } else {
      setDisplayValue(value);
    }
  }, [showRandom, value]);

  const diceImages = [dice1, dice2, dice3, dice4, dice5, dice6];

  return (
    <img
      src={diceImages[displayValue - 1]} // Gerekli yolu güncelle
      alt={`Dice ${displayValue}`}
      style={{ width: '250px', height: '250px' }} // Stil ayarlarını yapabilirsin
    />
  );
}

export default Dice;
