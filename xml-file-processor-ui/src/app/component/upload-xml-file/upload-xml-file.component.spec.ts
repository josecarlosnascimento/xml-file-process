import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadXmlFileComponent } from './upload-xml-file.component';

describe('UploadXmlFileComponent', () => {
  let component: UploadXmlFileComponent;
  let fixture: ComponentFixture<UploadXmlFileComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UploadXmlFileComponent]
    });
    fixture = TestBed.createComponent(UploadXmlFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
