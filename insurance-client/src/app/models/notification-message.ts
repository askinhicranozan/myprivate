import {Severities} from '../models/severities.type';

export class NotificationMessage {
    severity :Severities;
    summary : string;
    detail : string;
    
    constructor(severity :Severities,summary : string,detail :string) {
        this.severity = severity;
        this.summary = summary;
        this.detail = detail;
    }
}
