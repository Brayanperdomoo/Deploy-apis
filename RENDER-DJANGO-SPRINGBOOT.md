# 🎯 RENDER: Configuración Visual para Django y Spring Boot

---

## **📦 API DJANGO (Python/DRF)**

### **Paso 1: Formulario Principal**

```
┌────────────────────────────────────────────┐
│ Create a Web Service                       │
├────────────────────────────────────────────┤
│                                            │
│ Name                                       │
│ A unique name for your web service.        │
│ ┌──────────────────────────────────────┐   │
│ │ api-django                           │   │ ← COPIA ESTO
│ └──────────────────────────────────────┘   │
│                                            │
│ Project (Optional)                         │
│ ┌──────────────────────────────────────┐   │
│ │ Select a project...                  │   │ ← DÉJALO VACÍO
│ └──────────────────────────────────────┘   │
│                                            │
│ Environment                                │
│ ┌──────────────────────────────────────┐   │
│ │ Select an environment...             │   │ ← AUTOMÁTICO
│ └──────────────────────────────────────┘   │
│                                            │
│ Language                                   │
│ Choose the runtime environment             │
│ ┌──────────────────────────────────────┐   │
│ │ Python 3                        ▼    │   │ ← SELECCIONA PYTHON 3
│ └──────────────────────────────────────┘   │
│                                            │
│ Branch                                     │
│ The Git branch to build and deploy         │
│ ┌──────────────────────────────────────┐   │
│ │ main                                 │   │ ← DÉJALO EN main
│ └──────────────────────────────────────┘   │
│                                            │
│ Region                                     │
│ Your services in the same region can...    │
│ ┌──────────────────────────────────────┐   │
│ │ Ohio (US East)                  ▼    │   │ ← DÉJALO EN Ohio
│ └──────────────────────────────────────┘   │
│                                            │
│ Root Directory (Optional)                  │
│ If set, Render runs commands from this...  │
│ ┌──────────────────────────────────────┐   │
│ │ Api-Django                           │   │ ← COPIA ESTO
│ └──────────────────────────────────────┘   │
│                                            │
└────────────────────────────────────────────┘
```

### **Paso 2: Agregar Variables de Entorno**

Desplázate hacia abajo y busca **"Environment Variables"**:

```
┌────────────────────────────────────────────┐
│ Environment Variables                      │
│ Set environment-specific config...         │
├────────────────────────────────────────────┤
│                                            │
│ ┌─ Variable 1 ──────────────────────────┐  │
│ │ NAME: DEBUG                            │  │
│ │ VALUE: False                           │  │
│ └────────────────────────────────────────┘  │
│                                            │
│ ┌─ Variable 2 ──────────────────────────┐  │
│ │ NAME: ALLOWED_HOSTS                    │  │
│ │ VALUE: *                               │  │
│ └────────────────────────────────────────┘  │
│                                            │
│ ┌─ Variable 3 ──────────────────────────┐  │
│ │ NAME: SECRET_KEY                       │  │
│ │ VALUE: (Click "Generate")              │  │
│ └────────────────────────────────────────┘  │
│                                            │
│ [ + Add Environment Variable ]             │
│                                            │
└────────────────────────────────────────────┘
```

### **Paso 3: Resumen Rápido de Django**

| Campo | Valor |
|-------|-------|
| **Name** | `api-django` |
| **Language** | `Python 3` |
| **Branch** | `main` |
| **Region** | `Ohio (US East)` |
| **Root Directory** | `Api-Django` |
| **DEBUG** | `False` |
| **ALLOWED_HOSTS** | `*` |
| **SECRET_KEY** | `(Generate)` |

### **Paso 4: Crear servicio**

Haz scroll hasta abajo y haz clic en:
```
[ Create Web Service ]
```

Espera 5-10 minutos mientras Render:
- Descarga tu código
- Instala dependencias (`pip install -r requirements.txt`)
- Ejecuta migraciones (`python manage.py migrate`)
- Arranca el servidor (`gunicorn config.wsgi:application`)

---

## **📦 API SPRING BOOT (Docker)**

### **Paso 1: Formulario Principal**

```
┌────────────────────────────────────────────┐
│ Create a Web Service                       │
├────────────────────────────────────────────┤
│                                            │
│ Name                                       │
│ ┌──────────────────────────────────────┐   │
│ │ api-springboot                       │   │ ← COPIA ESTO
│ └──────────────────────────────────────┘   │
│                                            │
│ Project (Optional)                         │
│ ┌──────────────────────────────────────┐   │
│ │ Select a project...                  │   │ ← DÉJALO VACÍO
│ └──────────────────────────────────────┘   │
│                                            │
│ Environment                                │
│ ┌──────────────────────────────────────┐   │
│ │ Select an environment...             │   │ ← AUTOMÁTICO
│ └──────────────────────────────────────┘   │
│                                            │
│ Language                                   │
│ Choose the runtime environment             │
│ ┌──────────────────────────────────────┐   │
│ │ Docker                          ▼    │   │ ← SELECCIONA DOCKER
│ └──────────────────────────────────────┘   │
│                                            │
│ Branch                                     │
│ ┌──────────────────────────────────────┐   │
│ │ main                                 │   │ ← DÉJALO EN main
│ └──────────────────────────────────────┘   │
│                                            │
│ Region                                     │
│ ┌──────────────────────────────────────┐   │
│ │ Ohio (US East)                  ▼    │   │ ← DÉJALO EN Ohio
│ └──────────────────────────────────────┘   │
│                                            │
│ Root Directory (Optional)                  │
│ ┌──────────────────────────────────────┐   │
│ │ Api-SpringBoot                       │   │ ← COPIA ESTO
│ └──────────────────────────────────────┘   │
│                                            │
└────────────────────────────────────────────┘
```

### **⚠️ IMPORTANTE para Spring Boot**

Cuando selecciones **Docker**, Render automáticamente:
- ✅ Detectará el archivo [Dockerfile](../Api-SpringBoot/Dockerfile)
- ✅ Lo usará para compilar y ejecutar Spring Boot
- ✅ **NO necesitas variables de entorno**

```dockerfile
# Render ejecutará esto automáticamente:
FROM maven:3.9.9-eclipse-temurin-17 AS build
  → Compila el .jar

FROM eclipse-temurin:17-jre
  → Ejecuta el .jar en puerto 8080
```

### **Paso 2: Resumen Rápido de Spring Boot**

| Campo | Valor |
|-------|-------|
| **Name** | `api-springboot` |
| **Language** | `Docker` |
| **Branch** | `main` |
| **Region** | `Ohio (US East)` |
| **Root Directory** | `Api-SpringBoot` |
| **Environment Variables** | (Ninguna) |

### **Paso 3: Crear servicio**

Haz scroll hasta abajo y haz clic en:
```
[ Create Web Service ]
```

Espera 10-15 minutos mientras Render:
- Descarga tu código
- Detecta el Dockerfile
- Compila: `mvn clean package` (construye el .jar)
- Crea imagen Docker
- Arranca el contenedor en puerto 8080

---

## **✅ Resumen Final**

### **Django:**
```
Name: api-django
Language: Python 3
Root: Api-Django
Env Vars: DEBUG=False, ALLOWED_HOSTS=*, SECRET_KEY=(Generate)
```

### **Spring Boot:**
```
Name: api-springboot
Language: Docker
Root: Api-SpringBoot
Env Vars: (Ninguna)
```

---

## **🧪 Después de desplegar, prueba cada una:**

```bash
# Django
curl https://api-django.onrender.com/
curl https://api-django.onrender.com/libros/

# Spring Boot
curl https://api-springboot.onrender.com/
curl https://api-springboot.onrender.com/libros
```

Ambas deberían retornar JSON. ¡Listo! 🚀
