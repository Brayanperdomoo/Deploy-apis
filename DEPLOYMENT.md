# 📦 Guía de Despliegue en Render

Este repositorio está listo para desplegar en Render. Sigue estos pasos:

---

## **PASO 1: Preparar GitHub**

1. Sube el repositorio a GitHub (si no lo has hecho):
   ```bash
   git init
   git add .
   git commit -m "Cambio a entidad Libro y config para Render"
   git branch -M main
   git remote add origin https://github.com/TU-USUARIO/Tu-Repo.git
   git push -u origin main
   ```

2. En GitHub: **Settings** → **Secrets and variables** → **Actions**
3. Crea 3 secrets (cópialos del paso 3):
   - `RENDER_DEPLOY_HOOK_NODE`
   - `RENDER_DEPLOY_HOOK_DJANGO`
   - `RENDER_DEPLOY_HOOK_SPRING`

---

## **PASO 2: Crear Servicios en Render (con Blueprint)**

### **Opción A: Rápido (Recomendado) - Blueprint**

1. Dirígete a https://render.com/deploy
2. Conecta tu cuenta de GitHub
3. Selecciona el repositorio
4. En **Select branch**: `main`
5. En **Blueprint**: Sube [render.yaml](render.yaml)
6. Render automáticamente creará 3 servicios:
   - `api-node` (Express)
   - `api-django` (Django)
   - `api-springboot` (Spring Boot)
7. Espera a que terminen los builds (~5-10 min)

### **Opción B: Manual - Crear cada servicio**

#### **API Node**
1. Dashboard → **New** → **Web Service**
2. Conecta tu repo
3. Configura:
   - **Name**: `api-node`
   - **Root Directory**: `Api-Node`
   - **Runtime**: `Node`
   - **Build**: `npm install`
   - **Start**: `npm start`
4. **Create Service**

#### **API Django**
1. Dashboard → **New** → **Web Service**
2. Conecta tu repo
3. Configura:
   - **Name**: `api-django`
   - **Root Directory**: `Api-Django`
   - **Runtime**: `Python 3`
   - **Build**: `pip install -r requirements.txt && python manage.py migrate`
   - **Start**: `gunicorn config.wsgi:application`
4. **Environment Variables**:
   ```
   DEBUG=False
   ALLOWED_HOSTS=tu-render-app.onrender.com
   ```
5. **Create Service**

#### **API Spring Boot**
1. Dashboard → **New** → **Web Service**
2. Conecta tu repo
3. Configura:
   - **Name**: `api-springboot`
   - **Root Directory**: `Api-SpringBoot`
   - **Runtime**: `Docker`
   - (Render automáticamente detectará el Dockerfile)
4. **Create Service**

---

## **PASO 3: Configurar Deploy Hooks (Opcional pero recomendado)**

1. Para cada servicio en Render: **Settings** → **Deploy Hooks**
2. Haz clic en **+ Add Deploy Hook**
3. Nómbralo (ej: "GitHub") y copia la URL
4. En GitHub (tu repo): **Settings** → **Secrets and variables** → **Actions**
5. **New repository secret** y agrega:
   - Key: `RENDER_DEPLOY_HOOK_NODE`, Value: (pega URL del hook Node)
   - Key: `RENDER_DEPLOY_HOOK_DJANGO`, Value: (pega URL del hook Django)
   - Key: `RENDER_DEPLOY_HOOK_SPRING`, Value: (pega URL del hook Spring)

---

## **PASO 4: Verificar Despliegue**

Una vez que los servicios estén en verde (running):

- **Node**: https://tu-api-node.onrender.com/libros
- **Django**: https://tu-api-django.onrender.com/libros/
- **Spring**: https://tu-api-springboot.onrender.com/libros

Cada uno debe retornar un array vacío `[]` o un array con los libros.

---

## **PASO 5: Deploy automático (Opcional)**

Si configuraste los Deploy Hooks:
- Cada `git push` a `main` ejecuta el workflow `.github/workflows/deploy-render.yml`
- Valida las 3 APIs
- Dispara automáticamente los redeploys en Render

Sin los hooks, puedes redepployer manualmente desde el dashboard de Render.

---

## **Endpoints disponibles (en todas las APIs)**

```bash
# GET todos los libros
GET /libros

# GET un libro por ID
GET /libros/1

# POST crear libro
POST /libros
Body: { "titulo": "...", "autor": "...", "isbn": "...", "disponible": true }

# PUT actualizar libro
PUT /libros/1
Body: { "titulo": "...", "autor": "...", "isbn": "...", "disponible": true }

# DELETE eliminar libro
DELETE /libros/1
```

---

## **Troubleshooting**

- **"Build failed"**: Revisa los logs en Render Dashboard
- **"502 Bad Gateway"**: Espera unos segundos, puede estar iniciando
- **"Libro no encontrado"**: Confirma que el ID existe con GET /libros
- **Database error en Django**: Las migraciones se ejecutan en el build (`python manage.py migrate`)

---

¿Preguntas? Revisa el [README.md](README.md)
