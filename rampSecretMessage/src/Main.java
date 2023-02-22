import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please solve the challenge and submit solutions in the field below:");
        //https://0ijq1i6sp1.execute-api.us-east-1.amazonaws.com/dev *
        String junk = "oCggICAgICAgIEhlbGxvLAoKICAgICAgICBXZSdyZSBnbGFkIHlvdSdyZSBoZXJlIQoKICAgICAgICBSYW1wIGhhcyBiZWVuIGZvcnR1bmF0ZSB0byBleHBlcmllbmNlIGV4cG9uZW50aWFsIGdyb3d0aCBvdmVyIHRoZSBwYXN0CiAgICAgICAgZmV3IHllYXJzIGFuZCB3aXRoIGl0IG91ciBhcHBsaWNhdGlvbiB2b2x1bWUgaGFzIHN1cmdlZC4KCiAgICAgICAgSW4gdGhpcyBzaXR1YXRpb24sIG1hbnkgc3RhcnR1cHMgb3B0IHRvIHVzZSBvZmYtdGhlLXNoZWxmIHRpbWVkIGxlZXRjb2RlCiAgICAgICAgc3R5bGUgU2FhUyB0b29scyB0byB0aGluIGFwcGxpY2F0aW9uIHZvbHVtZS4KCiAgICAgICAgV2UgdGhvdWdodCBwdXp6bGVzIGluIHRoZSBzcGlyaXQgb2YgYSBDVEZbMV0gd291bGQgYmUgbW9yZSBmdW4gYW5kIGEKICAgICAgICBiZXR0ZXIgZXhwcmVzc2lvbiBvZiBvdXIgdmFsdWVzLiBBcyB3ZSBleHBlY3QgeW91IHRvIHNwZW5kIGEgbGl0dGxlIGJpdAogICAgICAgIG9mIHRpbWUgb24gdGhpcyBnYXRpbmcgY2hhbGxlbmdlLCB3ZSB0aG91Z2h0IGl0IHdhcyBhcHByb3ByaWF0ZSB0aGF0IHdlCiAgICAgICAgcHV0IHRpbWUgYW5kIGVmZm9ydCBpbnRvIGNyYWZ0aW5nIGl0IG91cnNlbHZlcy4KCiAgICAgICAgV2UncmUgYXdhcmUgYW5zd2VycyBoZXJlIG1pZ2h0IGV2ZW50dWFsbHkgYmUgbGVha2VkIGFuZCB3ZSdsbCBwcm9iYWJseQogICAgICAgIGhhdmUgdG8gcmVmcmVzaCB0aGlzIGV2ZXJ5IGNvdXBsZSBtb250aHMgb3Igc28sIGJ1dCBwbGVhc2Uga2VlcCBpbiBtaW5kCiAgICAgICAgaXQnbGwgYmUgdmVyeSBlYXN5IHRvIHRlbGwgb25jZSB0aGF0IGhhcHBlbnMgYW5kIHdpbGwgb25seSByZXN1bHQgaW4KICAgICAgICBzbG93aW5nIGRvd24gb3VyIGFiaWxpdHkgdG8gcHJvY2VzcyBhcHBsaWNhdGlvbnMgLSBzbyBwbGVhc2Uga2VlcCB0aGUKICAgICAgICBmbGFncyB0byB5b3Vyc2VsZi4KCiAgICAgICAgQWxsIGZsYWdzIGFyZSBzZXZlbiBsZXR0ZXIgZGljdGlvbmFyeSB3b3Jkcy4KCiAgICAgICAgQWxsIGZsYWcgZ2F0ZXMgYXJlIGluZGVwZW5kZW50IG9mIGVhY2ggb3RoZXIgLSBpLmUuIHlvdSBkb24ndCBuZWVkIHRvCiAgICAgICAgZmluZCBvbmUgZmxhZyB0byB1bmxvY2sgdGhlIG5leHQgb25lLgoKICAgICAgICBQbGVhc2Ugc3VibWl0IGF0IGxlYXN0IHR3byBmbGFncywgYnV0IGZlZWwgZnJlZSB0byBzdWJtaXQgYXMgbWFueSBhcyB5b3UKICAgICAgICBjYW4gZmluZC4KCiAgICAgICAgRW5qb3khCgogICAgICAgIC0gUmFtcCBFbmdpbmVlcmluZyA8Y3RmQHJhbXAuY29tPgoKCiAgICAgICAgMTogaHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvQ2FwdHVyZV90aGVfZmxhZ18oY3liZXJzZWN1cml0eSkKCgogICAgICAgIA==";
        String junk2 = "IyEvdXNyL2Jpbi9lbnYgcHl0aG9uMwoKJycnCktlZXAgdXMgb3V0IG9mIGdvb2dsZSBzZWFyY2ggcmVzdWx0cy4uCgokIG9kIC1kIC9kZXYvdXJhbmRvbSB8IGhlYWQKMDAwMDAwMCAgICAgNjAyMTUgICAyODc3OCAgIDI5MjI3ICAgMjg1NDggICA2MjY4NiAgIDQ1MTcxICAgIDc4MjYgICA0ODc2NgowMDAwMDIwICAgICAxNzExOCAgIDE1MjI1ICAgMTI4NTIgICAzNDc4MSAgIDMxOTU1ICAgMTkwODcgICAzOTU2MyAgIDQzNjE0CjAwMDAwNDAgICAgICA2NzEwICAgMzg1MTUgICAxNDU3MyAgIDY0MDg3ICAgMTcwMjYgICAyNTU5OCAgIDQyOTEzICAgMTQyMDkKMDAwMDA2MCAgICAgMTA3MjMgICAzMTMwNyAgIDE5MDcxICAgMTQ3OTggICAgMjQ2MiAgIDQ2MjUzICAgMzU2MjYgICAzMjQzNgowMDAwMTAwICAgICAgMTczOSAgIDI3NzEyICAgIDU2NjcgICAxMjIxMiAgIDQ3MDc3ICAgNDE3MjIgICA1NDQ1MiAgIDM4NDYxCjAwMDAxMjAgICAgICA0ODE2ICAgMTUwMTQgICAyODYyMyAgIDEwOTI4ICAgNTQwMjggICA2NDUyMyAgIDU0NjMyICAgNTQxODcKMDAwMDE0MCAgICAgNjE2MzEgICA1NDQ5OSAgIDE4MzA3ICAgIDU1MTQgICA1MDc0MyAgIDUwNTkxICAgMjUxNzIgICA1NDAxOAowMDAwMTYwICAgICAzMTk5MCAgIDI2MjQ4ICAgIDQzODMgICA0NjQ1MiAgIDQyMTU2ICAgNjIzMjAgICA1MTA1MiAgIDI4NjIxCjAwMDAyMDAgICAgIDI3MjI2ICAgNjUyOTYgICA1NjMwNSAgIDMzMzc1ICAgIDQ4MTMgICA0MjI4MyAgIDE5OTgwICAgIDE5MjIKMDAwMDIyMCAgICAgNTcwNjEgICAyOTMyMiAgIDI3MDczICAgNjQ5ODYgICAxNTIxOSAgIDI2MjM0ICAgMjQxMDAgICAyMTIwNAonJycKCicnJwpDb3B5IHRoaXMgZmlsZSBhbmQgcnVuIGBwYnBhc3RlIHwgYmFzZTY0YCB0byBnZW5lcmF0ZSBjaGFsbGVuZ2UgdGV4dC4gQ29waW91cwp3aGl0ZSBzcGFjZSBpcyBhdCB0aGUgYm90dG9tIG9mIHRoZSBmaWxlIHRvIGVuc3VyZSB0cmFpbGluZyBgPT1gIGFuZCBoaW50IGF0CmJhc2U2NC4KJycnCgppbXBvcnQgY29kZWNzCmltcG9ydCBzdHJpbmcKaW1wb3J0IHN5cwppbXBvcnQgdGltZQoKZnJvbSBjcnlwdG9ncmFwaHkuaGF6bWF0LmJhY2tlbmRzIGltcG9ydCBkZWZhdWx0X2JhY2tlbmQKZnJvbSBjcnlwdG9ncmFwaHkuaGF6bWF0LnByaW1pdGl2ZXMuaGFzaGVzIGltcG9ydCBTSEExCmZyb20gY3J5cHRvZ3JhcGh5Lmhhem1hdC5wcmltaXRpdmVzLnR3b2ZhY3Rvci50b3RwIGltcG9ydCBUT1RQCgoKT05FX1dFRUtfSU5fU0VDT05EUyA9IDYwNF84MDAKCgpkZWYgZ2VuZXJhdGVfc2VjcmV0KCk6CiAgICB0b3RwID0gVE9UUCgKICAgICAgICBrZXk9Y29kZWNzLmVuY29kZShzdHJpbmcuYXNjaWlfbGV0dGVycywgZW5jb2Rpbmc9InV0Zi04IiksCiAgICAgICAgbGVuZ3RoPTgsCiAgICAgICAgYWxnb3JpdGhtPVNIQTEoKSwKICAgICAgICB0aW1lX3N0ZXA9T05FX1dFRUtfSU5fU0VDT05EUywKICAgICAgICBiYWNrZW5kPWRlZmF1bHRfYmFja2VuZCgpLAogICAgKQogICAgc2VlZCA9IGludCh0aW1lLnRpbWUoKSkKICAgIHRva2VuID0gY29kZWNzLmRlY29kZSh0b3RwLmdlbmVyYXRlKHNlZWQpLCBlbmNvZGluZz0idXRmLTgiKQogICAgcmV0dXJuIGYie3Rva2VufS17c2VlZH0iCgoKaWYgX19uYW1lX18gPT0gIl9fbWFpbl9fIjoKICAgIHN5cy5zdGRvdXQud3JpdGUoCiAgICAgICAgZiJQbGVhc2UgaGVhZCB0byBodHRwczovL3JhbXAuY29tL2NhcmVlcnMgYW5kIHVzZSB0aGlzIHNlY3JldCB3aGVuICIKICAgICAgICBmInlvdSBhcHBseToge2dlbmVyYXRlX3NlY3JldCgpfVxuIgogICAgKQoKCg==";
//        displayLower(junk);
//       displayUpper(junk);
//       displayNumbers(junk);

        // going to put it into a character List to count occurances of frequent
//        List<Character> charList = new ArrayList<>();
//        for (int i = 0; i < junk.length(); i++) {
//            charList.add(junk.charAt(i));
//        }
//        displayMostFrequent(charList);
        stringDecode(junk);
    }

    public static void displayMostFrequent(List<Character> c){
        Map<Character, Integer> retMap = new HashMap<Character, Integer>();
        for (int i = 0; i < c.size(); i++) {
            int count = retMap.getOrDefault(c.get(i), 0);
            retMap.put(c.get(i), count +1);
        }
        System.out.println(retMap);
    }

    public static void displayUpper(String s){
        StringBuilder out = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))){
                out.append(s.charAt(i));
                counter++;
            }
        }
        System.out.println(out);
        System.out.println("Number of Upper letters - " + counter);
    }

    public static void displayLower(String s){
        StringBuilder out = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLowerCase(s.charAt(i))){
                out.append(s.charAt(i));
                counter++;
            }
        }
        System.out.println(out);
        System.out.println("Number of Lower letters - " + counter);
    }

    public static void displayNumbers(String s){
        int counter = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                out.append(s.charAt(i));
                counter++;
            }
        }
        System.out.println(out);
        System.out.println("Number of numbers - " + counter);
    }

    public static void stringDecode(String s){
        String decoded = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)));
        System.out.println(decoded);
    }


}