#!/usr/bin/env bash

set -a

function create_dbs_and_users() {

 db_login="PGPASSWORD=password psql -h localhost -p 5432 -U itmo -c "
  echo "db_login: ${db_login}"

  cmd="create database itmo"
  create_dat_cmd="${db_login}\"${cmd}\""
  echo "create_dat_cmd: ${create_dat_cmd}"

  cmd="CREATE USER itmo WITH PASSWORD 'password'"
  create_usr_cmd="${db_login}\"${cmd}\""
  echo "create_usr_cmd: ${create_usr_cmd}"

  cmd="GRANT ALL privileges ON DATABASE itmo TO itmo"
  grant_user_cmd="${db_login}\"${cmd}\""
  echo "grant_user_cmd: ${grant_user_cmd}"

  cmd="ALTER DATABASE itmo OWNER TO itmo"
  owner_user_cmd="${db_login}\"${cmd}\""
  echo "owner_user_cmd: ${owner_user_cmd}"

  eval "${create_dat_cmd}"
  eval "${create_usr_cmd}"
  eval "${grant_user_cmd}"
  eval "${owner_user_cmd}"
}

# call
create_dbs_and_users