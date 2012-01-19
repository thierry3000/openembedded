require linux-vuplus-3.1.1.inc

PR = "r6"

SRC_URI += "\
        file://linux_3.1.1_vusolo.patch;patch=1;pnum=1 \
        file://fix_cpu_proc_solo.patch;patch=1;pnum=1 \
	"

