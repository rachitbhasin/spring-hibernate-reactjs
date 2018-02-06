import React from 'react';
import { shallow, mount } from 'enzyme';
import Home from '../render.jsx';
import { initialState } from '../reducer'

function setup() {
    const props = {
        // Connected Functions
        onQueryChange: jest.fn(),
        // Connected Values
        query: initialState.query,
        names: initialState.names
    };

    const deepHome = mount(<Home {...props} />);
    const shallowHome = <Home {...props} />;

    return {
        props,
        deepHome,
        shallowHome
    }
}

describe('Home smoke test', () => {
    it('Home renders without crashing', () =>{
        const div = document.createElement('div');
        const { shallowHome } = setup();
        shallow(shallowHome, div);
    });
});