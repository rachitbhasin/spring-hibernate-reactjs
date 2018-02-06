import dc from "deep-copy";
import * as type from './actionTypes';

export const initialState = {
    names: ["earth", "sky", "fire", "water", "air"],
    query: ""
};

export default function home(state = initialState, action) {
    let nextState = dc(state);
    switch (action.type){
        case type.UPDATE_QUERY:
            nextState.query = action.query;
            return nextState;
        default:
            return state;
    }
}