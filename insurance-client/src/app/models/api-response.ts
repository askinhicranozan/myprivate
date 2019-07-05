import {ApiResponseStatus} from './api-response-status.enum'
import {ApiError} from './api-error'
import {ApiWarning} from './api-warning'

export interface ApiResponse {
    status : ApiResponseStatus;
    data : any;
    errors : Array<ApiError>;
    warnings : Array<ApiWarning>
}
