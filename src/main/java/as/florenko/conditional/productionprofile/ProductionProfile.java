package as.florenko.conditional.productionprofile;

import as.florenko.conditional.systemprofile.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
