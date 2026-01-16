class Solution
  def self.solve(input)
    running = 0
    input.reduce(0) do |max, n|
      running += n
      running = 0 unless running.positive?
      running > max ? running : max
    end
  end
end

if __FILE__ == $PROGRAM_NAME
  puts "#{Solution.solve([5])} = 5"
  puts "#{Solution.solve([1, 2, 3])} = 6"
  puts "#{Solution.solve([-2, 1, -7, 4, -3, 5, -10])} = 6"
  puts "#{Solution.solve([-1, -2, -3])} = 0"
end
