package co.manny.bnr.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Emmanuel on 10/15/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
