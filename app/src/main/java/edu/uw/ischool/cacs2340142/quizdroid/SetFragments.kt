package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat

 class SetFragments: PreferenceFragmentCompat() {
     override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
         setPreferencesFromResource(R.xml.preferences, rootKey)
     }
}