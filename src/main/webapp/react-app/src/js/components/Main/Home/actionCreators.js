import * as type from './actionTypes';

export function updateQuery (query) {
    return (dispatch) => {
        dispatch({type: type.UPDATE_QUERY, query});
    }
}