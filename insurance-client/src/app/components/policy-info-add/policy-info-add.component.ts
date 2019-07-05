
import { Component, OnInit } from '@angular/core';
import { BaseComponent } from '../../common/base-component';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { NotificationMessage } from '../../models/notification-message';
import { PolicyRegistrationInfo } from "src/app/models/policy-registration-info";
import { PolicyService } from "src/app/services/policy.service";
import { PolicyOutput } from "src/app/models/policy-output";
import { NotificationsService } from "src/app/services/notifications.service";




@Component({
    selector: 'app-policy-info-add',
    templateUrl: './policy-info-add.component.html',
    styleUrls: ['./policy-info-add.component.css']
})
export class PolicyInfoAddComponent extends BaseComponent implements OnInit{
    policyForm: FormGroup;
   registrationOutput:PolicyOutput;

  constructor(private formBuilder: FormBuilder,private policyService: PolicyService,private notificationsService: NotificationsService) {
      super();
  }

  ngOnInit() {
    
      this.fillPolicyForm();
  }

  fillPolicyForm() {
      this.policyForm = this.formBuilder.group( {
          'customerName': new FormControl( '' , Validators.required),
          'description': new FormControl( '' , Validators.required),
          'type': new FormControl( '' ,Validators.required),
          'productName': new FormControl( '' ,Validators.required),
          'time': new FormControl( '' ,Validators.required),
          'price': new FormControl( '' ,Validators.required),
         

      } );
  } 
  

  registrationPolicy() {
      let policyInfo = new PolicyRegistrationInfo(this.policyForm.get( "description" ).value,
      this.policyForm.get( "type" ).value,this.policyForm.get("productName").value,this.policyForm.get("time").value,this.policyForm.get("price").value);
      policyInfo.description=this.policyForm.get("description").value;
      policyInfo.type=this.policyForm.get("type").value;
      policyInfo.productName=this.policyForm.get("productName").value;
      policyInfo.time=this.policyForm.get("time").value;
      policyInfo.price=this.policyForm.get("price").value;
       
      this.policyService.policyRegistration( policyInfo ).takeWhile(() => this.alive ).subscribe( result => {
          this.registrationOutput = result;
          if ( result ) {
              this.notificationsService.notify( [new NotificationMessage( "success", "Başarılı", "Kayıt oluşturuldu" )] );
          } else {
              this.notificationsService.notify( [new NotificationMessage( "error", "Hata"," Hata Kodu: " + "-1" )] );
          }
      } );
  }
  
}
