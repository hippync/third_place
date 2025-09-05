# Third Place — Community & Events Platform
A full‑stack SaaS to help local orgs create events, mobilize volunteers, and track impact. Built as a modular monolith (Spring Boot + Next.js) with a clear path to future microservices.

## TL;DR (for contributors)

- **Stack**: Java 21 • Spring Boot 3 • Spring Security • Spring Data JPA • PostgreSQL (+ PostGIS) • Redis • OpenSearch • React/Next.js (TypeScript) • Tailwind • shadcn/ui
- **Auth**: OIDC via **Keycloak** (local/staging). Keep provider‑agnostic for Cognito swap later.
- **Infra/DevOps**: Docker • Terraform • Helm • Kubernetes • GitHub Actions • OpenTelemetry • Prometheus/Grafana/Loki • SES (email via MailHog locally)
- **Run locally**: `docker compose up` → API, Web, Postgres, Redis, OpenSearch, Keycloak, MailHog.

## Monorepo layout (initial)

```
.
├── backend/                    # Spring Boot app (modular monolith)
│   ├── app/                    # modules: core, orgs, events, search, notifications
│   ├── build.gradle.kts
│   ├── src/main/resources/db/migration  # Flyway
│   └── Dockerfile
├── frontend/                   # Next.js 14 (App Router) + TypeScript
│   └── Dockerfile
├── infra/
│   ├── terraform/              # envs: dev, staging, prod
│   ├── helm/                   # charts: api, web, opensearch, redis, postgres, keycloak
│   └── github-actions/         # CI/CD workflows
├── ops/                        # runbooks, dashboards, SLOs
└── docker-compose.yml          # local dev stack

```

## Quick start (local)

1. **Prereqs**: Docker ≥ 24, Java 21, Node 18+, pnpm (or npm), Make (optional).
2. **Bootstrap**

```bash
# From repo root
cp .env.example .env   # fill in the local secrets where needed
docker compose up -d   # postgres, redis, opensearch, keycloak, mailhog, api, web

```

3. **Backend**

```bash
./gradlew :backend:bootRun
# Health check
curl -s http://localhost:8080/actuator/health

```

4. **Frontend**

```bash
cd frontend && npm install && npm run dev
# visit http://localhost:3000

```

5. **Keycloak**
- Admin console: `http://localhost:8081` (see `.env` for creds)
- Default realm: `thirdplace` with an OIDC client for `web` and `api`.

6. **MailHog**
- UI at `http://localhost:8025` (captures all local emails)
