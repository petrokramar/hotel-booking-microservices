const express = require('express');

const app = express();

const proxy = require('http-proxy-middleware');
const apiProxy = proxy('/api/',
  {
    target: process.env.BACKEND_URI,
    logLevel: 'debug',
    changeOrigin: true,
    secure: false
  });

app.use(apiProxy);

app.use(express.static(__dirname + '/dist'));

app.listen(process.env.PORT || 4200);
