import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appUnless]'
})
export class UnlessDirective {
  @Input() set appUnless(condition: boolean) {
    if (!condition) {
      this.vcRef.createEmbeddedView(this.templateRef)
    } else {
      this.vcRef.clear();
    }

  }
  // generic template ref used to acced the template 
  constructor(private templateRef: TemplateRef<any>, private vcRef: ViewContainerRef) {

  }

}
