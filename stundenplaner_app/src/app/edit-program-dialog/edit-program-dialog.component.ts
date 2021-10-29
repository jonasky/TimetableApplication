import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Program } from '../programs/program-overview/data/program';

export enum DialogType {
  ADD,
  EDIT,
}
export interface DialogProgramData {
  program: Program;
  dialogType: DialogType;
}

@Component({
  selector: 'app-edit-program-dialog',
  templateUrl: './edit-program-dialog.component.html',
  styleUrls: ['./edit-program-dialog.component.css'],
})
export class EditProgramDialogComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<EditProgramDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogProgramData
  ) {}

  ngOnInit(): void {}

  cancelDialog(): void {
    this.dialogRef.close();
  }
}
