import { Injectable } from '@angular/core';
import {ApiError} from 'src/app/models/api-error'
import {ApiWarning} from 'src/app/models/api-warning'

import {Severities} from '../models/severities.type';

import {NotificationMessage} from '../models/notification-message';
import { Subject } from "rxjs";

@Injectable()
export class NotificationsService {

    notificationChange: Subject<NotificationMessage[]> = new Subject<NotificationMessage[]>();

    notify(messages : NotificationMessage[]) {
        this.notificationChange.next(messages);
    }
    
    clear(){
        this.notificationChange.next([]);
    }
}
