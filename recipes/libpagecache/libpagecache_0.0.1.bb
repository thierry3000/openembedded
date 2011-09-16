DESCRIPTION = "Preloadable library to improve large file operations"
SECTION = "base"

SRCREV = "eca12e734788ac6b53038f59ca4ae4b131bcdb04"

inherit autotools opendreambox-git lib_package

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "libpagecache.so.0.0.0" > ${D}${sysconfdir}/ld.so.preload
}
