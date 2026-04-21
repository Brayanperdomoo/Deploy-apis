const express = require('express');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

let livros = [
  { id: 1, titulo: 'Cien años de soledad', autor: 'Gabriel García Márquez', isbn: '978-0060883287', disponible: true }
];

app.get('/', (req, res) => {
  res.json({ message: 'API Node.js funcionando' });
});

app.get('/libros', (req, res) => {
  res.json(livros);
});

app.get('/libros/:id', (req, res) => {
  const libro = livros.find(l => l.id === parseInt(req.params.id));
  if (!libro) return res.status(404).json({ message: 'Libro no encontrado' });
  res.json(libro);
});

app.post('/libros', (req, res) => {
  const newLibro = {
    id: livros.length ? livros[livros.length - 1].id + 1 : 1,
    titulo: req.body.titulo,
    autor: req.body.autor,
    isbn: req.body.isbn,
    disponible: req.body.disponible || true
  };
  livros.push(newLibro);
  res.status(201).json(newLibro);
});

app.put('/libros/:id', (req, res) => {
  const index = livros.findIndex(l => l.id === parseInt(req.params.id));
  if (index === -1) return res.status(404).json({ message: 'Libro no encontrado' });

  livros[index] = {
    ...livros[index],
    titulo: req.body.titulo ?? livros[index].titulo,
    autor: req.body.autor ?? livros[index].autor,
    isbn: req.body.isbn ?? livros[index].isbn,
    disponible: req.body.disponible ?? livros[index].disponible
  };

  res.json(livros[index]);
});

app.delete('/libros/:id', (req, res) => {
  const index = livros.findIndex(l => l.id === parseInt(req.params.id));
  if (index === -1) return res.status(404).json({ message: 'Libro no encontrado' });

  const deleted = livros.splice(index, 1);
  res.json({ message: 'Libro eliminado', libro: deleted[0] });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Servidor corriendo en puerto ${PORT}`);
});