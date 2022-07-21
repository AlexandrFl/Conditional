package as.florenko.conditional.profiles;
import as.florenko.conditional.systemprofile.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
