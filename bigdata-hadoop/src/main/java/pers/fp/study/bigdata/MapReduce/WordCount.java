package pers.fp.study.bigdata.MapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author fengpeng
 * @date 2020/3/29 19:50
 */

public class WordCount {

    /**
     *
     *  myMapper
     *
     */

    static class MyMapper extends Mapper<LongWritable,Text, Text, IntWritable> {

        Text word = new Text();
        IntWritable one = new IntWritable(1);

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            //获取行数据
            String line = value.toString();

            //对数据进行拆分
            String[] words = line.split(" ");

            //循环数组
            for (String s : words) {
                word.set(s);
                context.write(word,one);
            }

        }

    }

    /**
     *
     *  myReducer
     *
     */

    static class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

        IntWritable sum = new IntWritable();

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

            //定义一个计数器
            int counter = 0;

            //循环计数
            for (IntWritable i : values) {
                counter += i.get();
            }

            //reduce 阶段输出
            sum.set(counter);
            context.write(key,sum);

        }

    }

    /**
     *
     *  job
     *
     */

    public static void main(String[] args) {

        try {

            //获取配置对象
            Configuration conf = new Configuration();

            //创建job
            Job job = new Job(conf, "wordcount");

            //为job设置运行主类
            job.setJarByClass(WordCount.class);

            //设置map阶段的属性
            job.setMapperClass(MyMapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);
            FileInputFormat.addInputPath(job,new Path(args[0]));

            //设置reduce阶段的属性
            job.setReducerClass(MyReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            FileOutputFormat.setOutputPath(job,new Path(args[1]));

            //提交运行作业job并打印信息
            int isok = job.waitForCompletion(true)?0:1;

            //退出job
            System.exit(isok);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
