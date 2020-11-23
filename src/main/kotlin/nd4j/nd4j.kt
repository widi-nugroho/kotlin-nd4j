package nd4j

import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.indexing.NDArrayIndex
import org.nd4j.linalg.ops.transforms.Transforms.dot
import org.nd4j.linalg.ops.transforms.Transforms.sqrt


object ND4J {
    var x1 = Nd4j.arange(6.0)
    var x2 = Nd4j.linspace(0L, 10L, 6)
    fun zeros() {
        //buat matrix isi 0 bentuknya 4x6
        var zerosarr = Nd4j.zeros(4, 6)
        println(zerosarr)
    }

    fun info() {
        println(x1)
        println(x1.rank())//dimensi matrix
        println(x1.length())//banyak entry
        println(x1.dataType())
    }

    fun buatdariarray() {
        var arr2d = arrayOf(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(4.0, 5.0, 6.0))
        var x2d = Nd4j.createFromArray(arr2d)//buat dari array yang udah ada
        println(arr2d)
        println(x2d)
    }

    fun ngurut() {
        var urutan1 = Nd4j.arange(6.0)//ngurut sampe 6
        var urutan2 = Nd4j.linspace(2L, 10L, 4)//terkecil,terbesar,jumlah entry
        println(urutan1)
        println(urutan2)
    }

    fun shape() {
        println(x1)
        var shape1 = intArrayOf(2, 3)
        println(x1.reshape(shape1))//reshape
    }

    fun operasi() {
        var x3=x1.add(x2)//penjumlahan matrix
        println("Penjumlahan matrix")
        println(x3)
        println("Pengurangan matrix")
        println(x1.sub(x2))//pengurangan matrix
        print("Nilai min:")
        println(x3.min())//nilai terkecil
        print("Nilai max:")
        println(x3.max())//nilai terbesar
        println(x3.sum(0))//jumlah
    }
    fun transform(){
        var kuadra= doubleArrayOf(4.0, 9.0, 16.0, 25.0)
        var kuadrat=Nd4j.createFromArray(*kuadra)
        println(kuadrat)
        println("diakarin")
        println(sqrt(kuadrat))//diakarin
    }
    fun perkalian(){
        var m1= x1.reshape(2, 3)
        var m2=x2.reshape(3, 2)
        println("m1*m2 (2,3)*(3,2)=(2,2)")
        println(m1.mmul(m2))//m1*m2
        println("m2*m1 (3,2)*(2,3)=(3,3)")
        println(m2.mmul(m1))//m2*m1
        println("dot product")
        println(dot(m1, m2))
    }
    fun indexing(){
        println(x1)
        println("ambil index 3")
        println(x1.getFloat(3))
        println("interval 0 sampai 3")
        println(x1[NDArrayIndex.interval(0,3)])
        var y=Nd4j.reverse(x1.dup())
        println("duplikat x1 yang dibalik")
        println(y)
        println("tiap 2 elemen dikasih -1.0 pada ")
        var z=x1.dup()
        println(z.get(NDArrayIndex.interval(0,2,6)).assign(-1.0))
        println("ganti elemen ke 3 jadi -20.0")
        println(z.putScalar(3,-20.0))
    }
    fun stacking(){
        println(x1)
        println(x2)
        println("horizontal stack")
        println(Nd4j.hstack(x1,x2))
        println("vertical stack")
        println(Nd4j.vstack(x1,x2))
    }
}
fun main(){
    //ND4J.perkalian()
    ND4J.indexing()

}
