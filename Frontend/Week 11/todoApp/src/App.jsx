import React, { useState } from 'react';
import './App.css';

function App() {
  const [notes, setNotes] = useState([]);  // Notları tutmak için state
  const [searchTerm, setSearchTerm] = useState('');  // Arama terimi için state
  const [noteText, setNoteText] = useState('');  // Not girişi için state
  const [selectedColor, setSelectedColor] = useState('#FFEB3B');  // Renk seçimi için state

  const colors = ['#9c88ff', '#40739e', '#e84118', '#e1b12c', '#44bd32'];  // Renk seçenekleri

  // Not ekleme fonksiyonu
  const addNote = () => {
    if (noteText.trim()) {
      setNotes([...notes, { text: noteText, color: selectedColor }]);
      setNoteText('');  // Not eklendikten sonra text alanını temizle
    }
  };

  // Notları arama terimine göre filtreleme
  const filteredNotes = notes.filter(note =>
    note.text.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="app">
      <h1>Not Uygulaması</h1>

      {/* Arama Çubuğu */}
      <input
        type="text"
        placeholder="Ara..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />

      {/* Not Girişi */}
      <textarea
        placeholder="Notunuzu girin..."
        value={noteText}
        onChange={(e) => setNoteText(e.target.value)}
      />

      <div className="controls">
        {/* Renk Seçenekleri */}
        <div className="color-options">
          {colors.map(color => (
            <span
              key={color}
              className={`color-swatch ${selectedColor === color ? 'selected' : ''}`}
              style={{ backgroundColor: color }}
              onClick={() => setSelectedColor(color)}
            />
          ))}
        </div>

        {/* Not Ekle Butonu */}
        <button onClick={addNote}>Ekle</button>
      </div>

      {/* Notlar Listesi */}
      <div className="notes-list">
        {filteredNotes.map((note, index) => (
          <div key={index} className="note" style={{ backgroundColor: note.color }}>
            {note.text}
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
