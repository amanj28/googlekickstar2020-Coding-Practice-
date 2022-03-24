use std::cmp::Reverse;

fn main() {
    let (r, w) = (std::io::stdin(), std::io::stdout());
    let mut sc = IO::new(r.lock(), w.lock());

    let t: usize = sc.read();
    for case_num in 1..=t {
        let mut heap = std::collections::BinaryHeap::new();
        let n: usize = sc.read();
        let c: Vec<usize> = sc.vec(n);
        let mut out = vec![];
        let mut h = 1usize;
        for ci in c {
            heap.push(Reverse(ci));
            if let Some(&first) = heap.peek() {
                if first.0 <= h {
                    heap.pop();
                }
                h = h.max(first.0.min(heap.len()));
            }
            out.push(h);
        }
        sc.write(
            format!(
                "Case #{}: ",
                case_num,
            )
        );
        for i in 0..n-1 {
            sc.write(out[i]);
            sc.write(" ");
        }
        sc.write(out[n-1]);
        sc.write("\n");
    }
}

pub struct IO<R, W: std::io::Write>(R, std::io::BufWriter<W>);

impl<R: std::io::Read, W: std::io::Write> IO<R, W> {
    pub fn new(r: R, w: W) -> IO<R, W> {
        IO(r, std::io::BufWriter::new(w))
    }
    pub fn write<S: ToString>(&mut self, s: S) {
        use std::io::Write;
        self.1.write_all(s.to_string().as_bytes()).unwrap();
    }
    pub fn read<T: std::str::FromStr>(&mut self) -> T {
        use std::io::Read;
        let buf = self
            .0
            .by_ref()
            .bytes()
            .map(|b| b.unwrap())
            .skip_while(|&b| b == b' ' || b == b'\n' || b == b'\r' || b == b'\t')
            .take_while(|&b| b != b' ' && b != b'\n' && b != b'\r' && b != b'\t')
            .collect::<Vec<_>>();
        unsafe { std::str::from_utf8_unchecked(&buf) }
            .parse()
            .ok()
            .expect("Parse error.")
    }
    pub fn usize0(&mut self) -> usize {
        self.read::<usize>() - 1
    }
    pub fn vec<T: std::str::FromStr>(&mut self, n: usize) -> Vec<T> {
        (0..n).map(|_| self.read()).collect()
    }
    pub fn chars(&mut self) -> Vec<char> {
        self.read::<String>().chars().collect()
    }

    pub fn binary_vec(&mut self) -> Vec<u8> {
        self.read::<String>()
            .bytes()
            .map(|b| b - b'0')
            .collect()
    }
}
