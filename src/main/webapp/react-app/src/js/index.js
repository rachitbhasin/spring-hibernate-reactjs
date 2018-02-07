import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import store from './stores';
import App from './components';

render((
    <BrowserRouter basename="/app">
        <Provider store={ store }>
            <App/>
        </Provider>
    </BrowserRouter>
), document.getElementById('app'));
