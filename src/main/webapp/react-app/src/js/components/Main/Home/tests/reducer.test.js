import home, { initialState } from './../reducer';
import * as type from './../actionTypes';

describe('home reducer', () => {
    it('should return the initial state', () => {
        expect(home(undefined, {})).toEqual(initialState);
    });

    it(`should update query on ${type.UPDATE_QUERY} action`, () => {
        const query = 'wind';
        let expectedState = initialState;
        expectedState.query = query;
        expect(home(initialState, {
            type: type.UPDATE_QUERY, query
        })).toEqual(expectedState);
    });
});