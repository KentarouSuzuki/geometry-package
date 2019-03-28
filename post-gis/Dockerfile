FROM mdillon/postgis:9.5-alpine

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB gis
ENV POSTGRES_INITDB_ARGS "--encoding=UTF-8 --locale=C"

COPY ./dump.sql /docker-entrypoint-initdb.d/