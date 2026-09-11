#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
  CREATE DATABASE "razorpay-merchant-db";
  CREATE DATABASE "razorpay-payment-db";
  CREATE DATABASE "razorpay-operations-db";
  CREATE DATABASE "razorpay-vault-db";

  CREATE USER "$APP_DB_USER" WITH PASSWORD '$APP_DB_PASSWORD';

  GRANT ALL PRIVILEGES ON DATABASE "razorpay-merchant-db" TO "$APP_DB_USER";
  GRANT ALL PRIVILEGES ON DATABASE "razorpay-payment-db" TO "$APP_DB_USER";
  GRANT ALL PRIVILEGES ON DATABASE "razorpay-operations-db" TO "$APP_DB_USER";
  GRANT ALL PRIVILEGES ON DATABASE "razorpay-vault-db" TO "$APP_DB_USER";
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "razorpay-merchant-db" <<-EOSQL
  GRANT ALL ON SCHEMA public TO "$APP_DB_USER";
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "razorpay-payment-db" <<-EOSQL
  GRANT ALL ON SCHEMA public TO "$APP_DB_USER";
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "razorpay-operations-db" <<-EOSQL
  GRANT ALL ON SCHEMA public TO "$APP_DB_USER";
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "razorpay-vault-db" <<-EOSQL
  GRANT ALL ON SCHEMA public TO "$APP_DB_USER";
EOSQL
