# EduInvest

A Spring Boot API for an education savings platform. Parents (customers) sign up, register their children, and buy savings products toward things like WAEC, NECO, or JAMB fees. Independent agents sign customers up using a referral code and earn a bonus, which admins approve and pay out.

## Who does what

- **Customer** – signs up, adds children, buys a product for a child, views their purchase and transaction history.
- **Agent** – signs up (goes into a pending state), gets a referral code, earns a bonus per referred customer, requests withdrawals of their bonus balance.
- **Admin** – approves or rejects/blocks agents, reviews customers, approves withdrawal payouts, invites other admins.

## Stack

Java 21, Spring Boot 3.3, Spring Security with JWT, Spring Data JPA, H2 (default, in-memory) or Postgres, Lombok.

## Running it

```bash
./mvnw spring-boot:run
```

The app starts on `http://localhost:9077` using an in-memory H2 database, so there's nothing to set up first. A default admin account is seeded automatically on startup:

```
email: admin@eduinvest.local
password: ChangeMe123!
```

Change the seed credentials with the `SEED_ADMIN_EMAIL` / `SEED_ADMIN_PASSWORD` environment variables, and change the JWT signing secret with `JWT_SECRET` before deploying anywhere real.

To use Postgres instead of H2, edit `src/main/resources/application.properties`: comment out the H2 lines and uncomment the Postgres block.

## API overview

All endpoints are under `/api`.

**Auth** (public)
- `POST /auth/signup/customer` – firstName, lastName, gender, dob, phone, email, password, optional referralCode
- `POST /auth/signup/agent` – same fields, no referralCode; account starts as `PENDING` until an admin approves it
- `POST /auth/login` – email, password → JWT

**Customer** (role: CUSTOMER)
- `GET /customer/profile`
- `POST /customer/children`, `GET /customer/children`
- `POST /customer/products` – buy a product for a child
- `GET /customer/products`, `GET /customer/transactions`

**Agent** (role: AGENT)
- `GET /agent/profile` – includes referral code and bonus balance
- `GET /agent/referrals` – customers who signed up with this agent's code
- `POST /agent/withdrawals`, `GET /agent/withdrawals`

**Admin** (role: ADMIN)
- `GET /admin/agents?status=PENDING`
- `PUT /admin/agents/{id}/approve`, `/reject`, `/block`
- `GET /admin/customers`
- `GET /admin/withdrawals/pending`, `PUT /admin/withdrawals/{id}/pay`
- `POST /admin/invite` – create another admin account

Send the JWT from login as `Authorization: Bearer <token>` on every protected request.

## Notes

This started as a data-model-only sketch (no controllers or services, and a couple of broken JPA mappings) across a few earlier repos. This version fills in the missing security, service, and controller layers and fixes the model so it runs end to end: signup, referral tracking, product purchase, and the agent/admin withdrawal approval flow all work.
