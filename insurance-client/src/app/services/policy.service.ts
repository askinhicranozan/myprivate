import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonUtil } from 'src/app/common/common-util';
import { ApiResponse } from 'src/app/models/api-response';
import { PolicyRegistrationInfo } from "src/app/models/policy-registration-info";
import { Observable } from "rxjs";
import { PolicyOutput } from "src/app/models/policy-output";
@Injectable()
export class PolicyService {

  constructor(private http: HttpClient,private commonUtil:CommonUtil) { }
  
  policyRegistration( input: PolicyRegistrationInfo ): Observable<PolicyOutput> {
      let url = this.commonUtil.getCrmApiHost()+ '/api/v1/policy/savePolicy';
      return this.http.post( url, input ).map( response => ( <ApiResponse>response ).data);

  }
}
