import  { useState } from 'react';

function PlayerInput({ onNameChange }) {
  const [name, setName] = useState(''); // Kullanıcıdan gelen girdiyi tutacak state

  const handleNameChange = (event) => {
    setName(event.target.value); // Girdiyi state'e kaydet
  };

  const handleSubmit = () => {
    onNameChange(name); // Yeni ismi prop ile üst bileşene gönder
  };

  return (
    <div>
      <input 
        type="text" 
        value={name} 
        onChange={handleNameChange} 
        placeholder="Enter your name" 
      />
      <button onClick={handleSubmit}>Update Name</button>
    </div>
  );
}

export default PlayerInput;
