# The GDB 10.2 sources bundled by crash still use std::allocator::construct,
# which was deprecated in C++17 and removed in C++20. With gcc 16 (whose default
# C++ standard no longer provides it) the build fails with:
#
#   gdbsupport/default-init-alloc.h:52:12: error: 'construct' has not been
#   declared in 'class std::allocator<...>'
#
# Build the C++ sources with GNU C++17 to retain compatibility with the bundled
# GDB sources. CXXFLAGS is exported into the task environment, so the gdb
# sub-build picks this up.
#
# Carries the proposed meta-oe fix as a downstream bbappend; drop once merged:
# https://lists.openembedded.org/g/openembedded-devel/message/127605
CXXFLAGS:append:qcom = " -std=gnu++17"
