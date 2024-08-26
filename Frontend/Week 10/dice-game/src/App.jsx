import React, { useState } from 'react';
import PlayerInput from './components/PlayerInput.jsx';
import PlayerName from './components//PlayerName.jsx';
import Dice from './components/Dice.jsx';
import Result from './components/Result.jsx';

function App() {
  const [playerName, setPlayerName] = useState('Player 1');
  const [player2Name] = useState('Player 2');
  const [result, setResult] = useState('Roll the Dice');
  const [dice1, setDice1] = useState(1);
  const [dice2, setDice2] = useState(1);
  const [showRandom, setShowRandom] = useState(false);

  const handleNameChange = (newName) => {
    setPlayerName(newName.trim() === '' ? 'Player 1' : newName);
  };

  const rollDice = () => {
    setShowRandom(true);
    setTimeout(() => {
      const newDice1 = Math.floor(Math.random() * 6) + 1;
      const newDice2 = Math.floor(Math.random() * 6) + 1;
      setDice1(newDice1);
      setDice2(newDice2);

      if (newDice1 > newDice2) {
        setResult('Win');
      } else if (newDice1 < newDice2) {
        setResult('Lose');
      } else {
        setResult('Draw');
      }

      setShowRandom(false);
    }, 1000); // 3 saniye sonra gerçek sonuçları belirle
  };

  return (
    <div>
      <PlayerInput onNameChange={handleNameChange} />
      <Result result={result} />
      <div style={{ display: 'flex', justifyContent: 'space-between', width: '600px' }}>
        <div>
          <PlayerName name={playerName} />
          <Dice value={dice1} showRandom={showRandom} />
        </div>
        <div>
          <PlayerName name={player2Name} />
          <Dice value={dice2} showRandom={showRandom} />
        </div>
      </div>
      <button onClick={rollDice}>Roll</button>
    </div>
  );
}

export default App;
