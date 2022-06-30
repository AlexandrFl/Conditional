package as.florenko.conditional.devprofile;
import as.florenko.conditional.systemprofile.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
