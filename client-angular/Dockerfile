FROM nginx:stable-alpine
MAINTAINER Petro Kramar <peter.v.kramar@gmail.com>

ENV LANG="en_US.UTF-8" \
    LC_ALL="en_US.UTF-8" \
    LANGUAGE="en_US.UTF-8" \
    TERM="xterm"
ENV TIMEZONE="Europe/Kiev"

RUN apk update && \
    apk upgrade && \
    apk add --update tzdata && \
    cp /usr/share/zoneinfo/${TIMEZONE} /etc/localtime && \
    echo "${TIMEZONE}" > /etc/timezone

RUN apk del tzdata && \
    rm -rf /var/cache/apk/*

COPY docker/conf/website.conf /etc/nginx/conf.d/website.conf

COPY dist /usr/share/nginx/html
