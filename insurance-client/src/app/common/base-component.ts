import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { OnDestroy } from '@angular/core';

export class BaseComponent implements OnDestroy {
    
    alive: boolean = true;

    isFieldNotValid( form: FormGroup, field: string ) {
        return !form.get( field ).valid && form.get( field ).touched;
    }

    validateAllFormFields( formGroup: FormGroup ) {
        Object.keys( formGroup.controls ).forEach( field => {
            const control = formGroup.get( field );
            if ( control instanceof FormControl ) {
                control.markAsTouched( { onlySelf: true } );
            } else if ( control instanceof FormGroup ) {
                this.validateAllFormFields( control );
            }
        });
    }
    
   restrictNumeric(e) {
        let input;
        if (e.metaKey || e.ctrlKey) {
          return true;
        }
        if (e.which === 32) {
         return false;
        }
        if (e.which === 0) {
         return true;
        }
        if (e.which < 33) {
          return true;
        }
        input = String.fromCharCode(e.which);
        return !!/[\d\s]/.test(input);
   }
   
   ngOnDestroy() {
       this.alive = false; //For unsubscribe from observers
   }
}
