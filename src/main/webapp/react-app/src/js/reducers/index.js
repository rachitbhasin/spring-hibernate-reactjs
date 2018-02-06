import { combineReducers } from 'redux';
import home from '../components/Main/Home/reducer';

const indexReducer = combineReducers({
    home
});

export default indexReducer;