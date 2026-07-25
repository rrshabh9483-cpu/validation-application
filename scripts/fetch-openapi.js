const fs = require("fs");
const path = require("path");

const url = process.env.API_DOCS_URL || "http://localhost:9292/v3/api-docs";
const outDir = path.join(__dirname, "..", "openapi");
const outFile = path.join(outDir, "openapi.json");

async function main() {
  const response = await fetch(url);

  if (!response.ok) {
    throw new Error(`Failed to fetch OpenAPI spec from ${url}: ${response.status}`);
  }

  const spec = await response.json();
  fs.mkdirSync(outDir, { recursive: true });
  fs.writeFileSync(outFile, JSON.stringify(spec, null, 2));
  console.log(`OpenAPI spec saved to ${outFile}`);
}

main().catch((error) => {
  console.error(error.message);
  process.exit(1);
});
