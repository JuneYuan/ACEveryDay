        List<List<String>> ret = new ArrayList<>();

        if (strs == null || strs.length == 0)   return ret;

        // one key to multiple value multiMap
        Map<String, ArrayList<String>> multiMap = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String sortedS = String.valueOf(chs);
            if (multiMap.containsKey(sortedS)) {
                ArrayList<String> list = multiMap.get(sortedS);
                list.add(s);
                multiMap.put(sortedS, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                multiMap.put(sortedS, list);
            }
        }

        // add List group to ret
        Set<String> keySet = multiMap.keySet();
        for (String key : keySet) {
            ret.add(multiMap.get(key));
        }

        return ret;
