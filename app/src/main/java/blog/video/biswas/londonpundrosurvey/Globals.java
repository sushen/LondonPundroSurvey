package blog.video.biswas.londonpundrosurvey;

import android.widget.CheckBox;
import android.widget.RadioButton;

public class Globals {
    public static Globals instance;



    public static synchronized Globals getInstance()
    {
        if(instance==null)
        {
            instance=new Globals();
        }
        return instance;
    }




    // Value return from CheckBox for 1 buttons
    public String GetValueFromCheckButton1(CheckBox CheckValue1) {
        String GetCheckValue = "";

        if (CheckValue1.isChecked() == false) {
            GetCheckValue = "0";
        } else {
            if (CheckValue1.isChecked() == true) {
                GetCheckValue = "1";
            }
        }
        return GetCheckValue;
    }

    // Value return from RadioButton for 2 buttons
    private String GetValueFromRadioButton2(RadioButton RadioValue1, RadioButton RadioValue2) {
        String GetRadioValue = "";

        if (RadioValue1.isChecked() == false && RadioValue2.isChecked() == false) {
            GetRadioValue = "";
        } else {
            if (RadioValue1.isChecked() == true) {
                GetRadioValue = "1";
            } else {
                if (RadioValue2.isChecked() == true) {
                    GetRadioValue = "2";
                }
            }
        }
        return GetRadioValue;
    }

    // Value return from RadioButton for 3 buttons
    public String GetValueFromRadioButton3(RadioButton RadioValue1, RadioButton RadioValue2, RadioButton RadioValue3) {
        String GetRadioValue = "";

        if (RadioValue1.isChecked() == false && RadioValue2.isChecked() == false && RadioValue3.isChecked() == false) {
            GetRadioValue = "";
        } else {
            if (RadioValue1.isChecked() == true) {
                GetRadioValue = "1";
            } else {
                if (RadioValue2.isChecked() == true) {
                    GetRadioValue = "2";
                } else {
                    if (RadioValue3.isChecked() == true) {
                        GetRadioValue = "3";
                    }
                }
            }
        }
        return GetRadioValue;
    }

    // Value return from RadioButton for 4 buttons
    public String GetValueFromRadioButton4(RadioButton RadioValue1, RadioButton RadioValue2, RadioButton RadioValue3, RadioButton RadioValue4) {
        String GetRadioValue = "";

        if (RadioValue1.isChecked() == false && RadioValue2.isChecked() == false && RadioValue3.isChecked() == false && RadioValue4.isChecked() == false ) {
            GetRadioValue = "";
        } else {
            if (RadioValue1.isChecked() == true) {
                GetRadioValue = "1";
            } else {
                if (RadioValue2.isChecked() == true) {
                    GetRadioValue = "2";
                } else {
                    if (RadioValue3.isChecked() == true) {
                        GetRadioValue = "3";
                    } else {
                        if (RadioValue4.isChecked() == true) {
                            GetRadioValue = "4";
                        }
                    }
                }
            }
        }
        return GetRadioValue;
    }

    // Value return from RadioButton for 7 buttons
    public String GetValueFromRadioButton7(RadioButton RadioValue1, RadioButton RadioValue2, RadioButton RadioValue3, RadioButton RadioValue4, RadioButton RadioValue5, RadioButton RadioValue6, RadioButton RadioValue7) {
        String GetRadioValue = "";

        if (RadioValue1.isChecked() == false && RadioValue2.isChecked() == false && RadioValue3.isChecked() == false && RadioValue4.isChecked() == false && RadioValue5.isChecked() == false && RadioValue6.isChecked() == false && RadioValue7.isChecked() == false) {
            GetRadioValue = "";
        } else {
            if (RadioValue1.isChecked() == true) {
                GetRadioValue = "1";
            } else {
                if (RadioValue2.isChecked() == true) {
                    GetRadioValue = "2";
                } else {
                    if (RadioValue3.isChecked() == true) {
                        GetRadioValue = "3";
                    } else {
                        if (RadioValue4.isChecked() == true) {
                            GetRadioValue = "4";
                        } else {
                            if (RadioValue5.isChecked() == true) {
                                GetRadioValue = "5";
                            } else {
                                if (RadioValue6.isChecked() == true) {
                                    GetRadioValue = "6";
                                }else {
                                    if (RadioValue7.isChecked() == true) {
                                        GetRadioValue = "7";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return GetRadioValue;
    }

}
