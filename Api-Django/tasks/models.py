from django.db import models

class Libro(models.Model):
    titulo = models.CharField(max_length=100)
    autor = models.CharField(max_length=100)
    isbn = models.CharField(max_length=20, unique=True)
    disponible = models.BooleanField(default=True)

    def __str__(self):
        return self.titulo