# Validation Application

Spring Boot REST API for user management with OpenAPI documentation powered by **springdoc**, **Swagger CLI**, and **Redocly**.

---

## API Documentation

This project uses three tools for API documentation:

| Tool | Purpose |
|------|---------|
| **springdoc-openapi** | Auto-generates OpenAPI spec and Swagger UI from Spring controllers |
| **Swagger CLI** | Validates and bundles the OpenAPI specification |
| **Redocly CLI** | Lints, previews, and builds static Redoc HTML documentation |

---

### Prerequisites

Before generating documentation, make sure you have:

- **Java 17+** installed
- **Node.js 18+** and **npm** installed
- **MySQL** running with the database configured in `application.yml`
- The Spring Boot application running on port **9292**

---

### Step 1: Start the Spring Boot Application

From the project root, start the application:

```bash
./mvnw spring-boot:run
```

On Windows (PowerShell):

```powershell
.\mvnw.cmd spring-boot:run
```

Wait until you see `Started ValidationApplication` in the console.

---

### Step 2: Install Documentation Dependencies

Open a **new terminal** in the project root and install the Node.js tools (Swagger CLI and Redocly CLI):

```bash
npm install
```

This installs:
- `@apidevtools/swagger-cli` — validate and bundle OpenAPI specs
- `@redocly/cli` — lint, preview, and build Redoc docs

---

### Step 3: View Live Swagger UI

With the app running, open Swagger UI in your browser:

```
http://localhost:9292/swagger-ui/index.html
```

From here you can:
- Browse all API endpoints
- View request/response schemas
- Try out API calls directly from the browser

The raw OpenAPI JSON is also available at:

```
http://localhost:9292/v3/api-docs
```

---

### Step 4: Fetch the OpenAPI Spec from the Running App

Pull the latest API spec from the running server and save it locally:

```bash
npm run fetch-spec
```

This creates/updates:

```
openapi/openapi.json
```

To use a different server URL:

```bash
# Linux / macOS
API_DOCS_URL=http://localhost:9292/v3/api-docs npm run fetch-spec

# Windows PowerShell
$env:API_DOCS_URL="http://localhost:9292/v3/api-docs"; npm run fetch-spec
```

---

### Step 5: Validate the Spec with Swagger CLI

Validate the fetched OpenAPI JSON file:

```bash
npm run validate-spec
```

Expected output:

```
openapi/openapi.json is valid
```

---

### Step 6: Bundle the Spec to YAML

Convert the JSON spec into a bundled YAML file for Redocly:

```bash
npm run bundle-spec
```

This creates:

```
openapi/openapi.yaml
```

---

### Step 7: Sync Spec (Fetch + Validate + Bundle)

Run all three steps above in one command:

```bash
npm run sync-spec
```

Use this whenever you change controllers or DTOs and want to refresh the local OpenAPI files.

---

### Step 8: Lint the Spec with Redocly

Check the OpenAPI file for errors and best-practice warnings:

```bash
npm run docs:lint
```

Configuration is in `redocly.yaml`.

---

### Step 9: Preview Redoc Documentation

Start a local preview server for the Redoc documentation:

```bash
npm run docs:preview
```

Redocly will print a local URL (usually `http://127.0.0.1:8080`). Open it in your browser to view the formatted API docs.

Press `Ctrl + C` to stop the preview server.

---

### Step 10: Build Static HTML Documentation

Generate a standalone HTML documentation file:

```bash
npm run docs:build
```

Output file:

```
docs/index.html
```

Open `docs/index.html` in any browser to view the documentation offline or share it with your team.

---

## Quick Reference — All Documentation Commands

| Command | Description |
|---------|-------------|
| `npm install` | Install Swagger CLI and Redocly CLI |
| `npm run fetch-spec` | Download OpenAPI spec from running app |
| `npm run validate-spec` | Validate spec with Swagger CLI |
| `npm run bundle-spec` | Bundle JSON spec to YAML |
| `npm run sync-spec` | Fetch + validate + bundle in one step |
| `npm run docs:lint` | Lint spec with Redocly |
| `npm run docs:preview` | Preview Redoc docs in browser |
| `npm run docs:build` | Build static HTML docs |

---

## Documentation URLs (App Must Be Running)

| Resource | URL |
|----------|-----|
| Swagger UI | http://localhost:9292/swagger-ui/index.html |
| OpenAPI JSON | http://localhost:9292/v3/api-docs |

---

## Recommended Workflow

1. Start the Spring Boot app (`.\mvnw.cmd spring-boot:run`)
2. Develop or update your API endpoints
3. Verify changes in Swagger UI
4. Run `npm run sync-spec` to update local OpenAPI files
5. Run `npm run docs:lint` to check for issues
6. Run `npm run docs:build` to generate static Redoc HTML
7. Commit `openapi/openapi.yaml` if you want version-controlled API docs

---

## Project Structure (Documentation Files)

```
validation/
├── openapi/
│   ├── openapi.json      # Fetched from /v3/api-docs
│   └── openapi.yaml      # Bundled YAML for Redocly
├── docs/
│   └── index.html        # Generated static Redoc documentation
├── scripts/
│   └── fetch-openapi.js  # Script to fetch spec from running app
├── redocly.yaml          # Redocly lint and theme configuration
└── package.json          # npm scripts for documentation tooling
```
