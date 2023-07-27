import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl, ValidationErrors } from '@angular/forms';

 

@Directive({
  selector: '[appEmailFormat]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: EmailFormatDirective,
    multi: true
  }]
})
export class EmailFormatDirective implements Validator {
  validate(control: AbstractControl): ValidationErrors | null {
    const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
    const email = control.value;

 

    if (email && !emailRegex.test(email)) {
      return { 'emailFormat': true };
    }

 

    return null;
  }
}